import React, { useContext, useEffect } from "react";
import { MapContext } from "./Map";

function Store(props) {
  const { kakao, mapInfo, stores, changeValue } = useContext(MapContext);

  useEffect(() => {
    var positions = [];
    var linePath = [];

    // //선택한 Course에 해당하는 Node만 배열에 담기
    var store = stores.filter((item) => {
      return item.courseNode === mapInfo.nodeId;
    });

    store.map((item) => {
      positions.push({
        id: item.id,
        courseId: item.course,
        title: item.location,
        latlng: new kakao.maps.LatLng(item.latitude, item.longitude),
      });
    });

    //노드의 중심좌표 구하기 위해 경도, 위도끼리 더해줌
    var la = 0,
      ma = 0;
    positions.map((item) => {
      la += item.latlng.La;
      ma += item.latlng.Ma;
      linePath.push(new kakao.maps.LatLng(item.latlng.Ma, item.latlng.La)); //선그리기 위한 좌표 담기
    });

    var mapContainer = document.getElementById("map"), // 지도를 표시할 div
      mapOption = {
        center: new kakao.maps.LatLng(
          ma / positions.length,
          la / positions.length
        ), // 노드의 중심좌표
        level: 7, // 지도의 확대 레벨
      };

    var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

    // 마커 이미지의 이미지 주소입니다
    var imageSrc = require("assets/img/icons/ottc/store_maker.png");

    positions.map((item) => {
      // 마커 이미지의 이미지 크기 입니다
      var imageSize = new kakao.maps.Size(24, 24);

      // 마커 이미지를 생성합니다
      var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

      // 마커를 생성합니다
      var marker = new kakao.maps.Marker({
        map: map, // 마커를 표시할 지도
        position: item.latlng, // 마커를 표시할 위치
        title: item.title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
        image: markerImage, // 마커 이미지
      });

      //마커에 클릭 이벤트 등록
      kakao.maps.event.addListener(marker, "click", () => {
        mapInfo.nodeId = item.id;
        changeValue();
      });
    });
  }, []);

  return <div id="map"> </div>;
}

export default Store;
