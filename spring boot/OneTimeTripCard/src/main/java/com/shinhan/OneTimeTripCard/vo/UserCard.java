package com.shinhan.OneTimeTripCard.vo;

import java.time.LocalDateTime;


public class UserCard {
	Long user_id;
	char card_no;	//ī��ѹ�
	Long manager_id;  // nullable ���� ������ ����
	char nickname;  // ī�庰Ī
	char level;  // ī����
	Integer balance;  // ī���ܾ�
	Integer discount_amount;  // ���� ���� �Ѿ�
	Integer recharge_count;  // �� ���� Ƚ��
	Boolean status; // ī�� ���� ���� Y, N
	LocalDateTime create_at;	//ī�� ������¥
	LocalDateTime expired_at;	//���ᳯ¥
	Boolean is_group; // Y, N
	// �������� ������ Ȱ��ȭ�� user_card ���ε���
	// status�� ���� ��Ȱ��ȭ �����ش�.
	Boolean isDefault; // Y, N �⺻ī��

}
