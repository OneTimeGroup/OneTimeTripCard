package com.shinhan.OneTimeTripCard.vo;

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
public class ExchangeRate {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; //pk
	private String curUni;  // ��ȭ�ڵ�
	private String curName ; // ����/��ȭ��
	private String ttb; // ����ȯ(�۱�) �����Ƕ�
	private String tts; // ����ȯ(�۱�) �����Ƕ�
	private String dealBasRate; // �Ÿ� ������

	  // �� ���̺��� 9��~ 3��30�� - 1�д��� ������Ʈ
	  // 3�� 30�� ~ 6�� - 30�� ���� ������Ʈ(�ð��� �ŷ�)
	  // 6�� ���� ~ �ϰ� ���� (������Ʈ x)
	  //�񿵾����� ������, Ȥ�� �������� 11�� ������ �ش����� �����͸� ��û�� ��� null ���� ��ȯ

}
