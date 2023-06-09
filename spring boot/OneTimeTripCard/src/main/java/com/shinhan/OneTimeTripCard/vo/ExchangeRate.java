package com.shinhan.OneTimeTripCard.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRate {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; //pk
	
	@JsonProperty("cur_unit")
	private String curUnit;  // 통화코드
	
	@JsonProperty("cur_nm")
	private String curName; // 국가/통화명
	
	@JsonProperty("ttb")
	private String ttb; // 전신환(송금) 받으실때
	
	@JsonProperty("tts")
	private String tts; // 전신환(송금) 보내실때
	
	@JsonProperty("deal_bas_r")
	private String dealBasRate; // 매매 기준율

	  // 이 테이블은 9시~ 3시30분 - 1분단위 업데이트
	  // 3시 30분 ~ 6시 - 30분 단위 업데이트(시간외 거래)
	  // 6시 이후 ~ 일괄 적용 (업데이트 x)
	  //비영업일의 데이터, 혹은 영업당일 11시 이전에 해당일의 데이터를 요청할 경우 null 값이 반환

}