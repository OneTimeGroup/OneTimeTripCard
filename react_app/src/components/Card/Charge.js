import React, { useEffect, useState } from "react";
import Button from "react-bootstrap/Button";
import Col from "react-bootstrap/Col";
import Form from "react-bootstrap/Form";
import Row from "react-bootstrap/Row";
import { useLocation, useNavigate } from "react-router-dom";
import CardDefaultInfo from "./CardDefaultInfo";
import axios from "axios";
import TravelCardCharge from "./TravelCardCharge";

function Charge() {
  const location = useLocation();
  const userCard = location.state.userCard;
  const [exchange, setExchange] = useState(0);
  const [OWN, setOWN] = useState(0);
  const [KRW, setKRW] = useState(0);

  //그룹이면 true , 개인이면 false
  const currentState = location.pathname.split("/")[1] === "travelCard";
  console.log(currentState);

  useEffect(() => {
    axios
      .get(
        `/exchange-rate/charge?currencyName=${userCard.user.preferredCurrency}`
      )
      .then((res) => {
        setExchange(Math.floor(res.data));
      });
  }, []);

  //충전 요청하기
  const onCharge = () => {
    let requestUrl = "";
    let nextUrl = "";
    // 개인 카드인 경우
    if (!currentState) {
      requestUrl = "/charge";
      nextUrl = "/card";
    } else {
      // travelWith 카드인 경우
      requestUrl = "/charge/travelWith";
      nextUrl = "/travelCard";
    }
    axios
      .post(requestUrl, {
        userCard: userCard,
        currency: userCard.user.preferredCurrency,
        rate: exchange,
        amount: OWN,
        amountWon: KRW,
      })
      .then(() => {
        navigate(nextUrl);
      });
  };

  //환전계산
  const onExchange = (e) => {
    if (e.target.getAttribute("data") === "KRW") {
      setOWN(() => (e.target.value / exchange).toFixed(2));
      setKRW(() => Math.floor(e.target.value));
    } else {
      setOWN(() => e.target.value);
      setKRW(() => Math.floor(e.target.value * exchange));
    }
  };

  const navigate = useNavigate();

  const deleteCard = () => {
    if (window.confirm(`${userCard.nickName} 카드를 정말 삭제하겠습니까?`)) {
      axios.delete(`/user-card/delete/${userCard.id}`).then((userCards) => {
        navigate("/card");
      });
    }
  };

  return (
    <>
      <CardDefaultInfo />
      <Form className="m-auto" style={{ width: "500px" }}>
        {currentState && <TravelCardCharge userCard={userCard} />}
        <Form.Group as={Row} className="mb-3" controlId="formHorizontalEmail">
          <Form.Label column sm={2} style={{ fontWeight: 800 }}>
            KRW
          </Form.Label>
          <Col sm={10}>
            <Form.Control
              type="number"
              placeholder={KRW}
              onChange={onExchange}
              value={KRW}
              data="KRW"
            />
          </Col>
        </Form.Group>
        <Form.Group
          as={Row}
          className="mb-3"
          controlId="formHorizontalPassword"
        >
          <Form.Label column sm={2} style={{ fontWeight: 800 }}>
            {userCard.user.preferredCurrency.toUpperCase()}
          </Form.Label>
          <Col sm={10}>
            <Form.Control
              type="number"
              placeholder={OWN}
              onChange={onExchange}
              value={OWN}
              data="OWN"
            />
          </Col>
        </Form.Group>
        <Form.Group
          as={Row}
          className="mb-3"
          controlId="formHorizontalPassword"
        >
          <Form.Label column sm={2} style={{ fontWeight: 800 }}>
            withdraw
          </Form.Label>
          <Col sm={10}>
            <Form.Control
              type="number"
              placeholder={userCard.user.accountNo}
              disabled
            />
          </Col>
        </Form.Group>
        <Form.Group
          as={Row}
          className="mb-3"
          controlId="formHorizontalPassword"
        >
          <Form.Label column sm={2} style={{ fontWeight: 800 }}>
            Recharge Count
          </Form.Label>
          <Col sm={10}>
            <Form.Control
              type="number"
              placeholder={
                userCard.grade.maxRechargeCount - userCard.rechargeCount
              }
              disabled
            />
          </Col>
        </Form.Group>
        <Form.Group className="mb-3 text-center btn-block">
          <Button onClick={() => navigate(-1)}>BACK</Button>
          <Button onClick={onCharge}>CHARGE</Button>
          <Button onClick={deleteCard}>DELETE</Button>
        </Form.Group>
      </Form>
    </>
  );
}

export default Charge;
