package com.shinhan.OneTimeTripCard.vo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
public class Charge {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; // pk
	private Long chargerId; // ������ ���̵�
	private String cardNo; // ī�� ��ȣ
	private String currency; // ��ȭ($)
	private Double rate;  // ȯ��(���� ���)
	private Double amount; // ���� �ݾ�(�ڱ� ��ȭ)
	private Integer amountWon; // ���� �ݾ�(��ȭ)
	private Double commissionPct; // ������
	private LocalDateTime createdAt;
}
