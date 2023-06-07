package com.shinhan.OneTimeTripCard.vo;

import javax.persistence.Entity;

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
public class Level {
	private String levelName; //pk // gold, silver, etc
	private Integer minimumAmount; // pk
	private Integer period; // pk
	private Double refundRate;
	private Integer benefitCount;
	private String imgSrc;
	private Integer maxRechargeCount; // ������ ���� Ƚ��
	private Integer deliveryCount; // ���� ��ȭ�� Ƚ��(���, ���̾Ƹ�)
 }
