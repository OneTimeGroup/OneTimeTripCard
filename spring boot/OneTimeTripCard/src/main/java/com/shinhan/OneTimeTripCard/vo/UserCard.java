package com.shinhan.OneTimeTripCard.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sun.istack.NotNull;

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
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@Table
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class UserCard {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; // pk
	@ManyToOne
	@JoinColumn(name = "user_id")
	@NotNull
	private User user;
	@ManyToOne
	@JoinColumn(name = "card_no")
	private Card card; // 카드넘버
	@OneToOne
	@JoinColumn(name = "manager_id")
	private User manager; // nullable 모임 통장일 때만
	private String nickName; // 카드별칭
	@OneToOne
	@JoinColumn(name = "grade_id")
	private Grade grade; // 카드등급

	@ManyToMany
	@JsonIgnore
	@JoinTable(name = "card_benefit", joinColumns = @JoinColumn(name = "user_card_id"), inverseJoinColumns = @JoinColumn(name = "benefit_id"))
	private List<Benefit> benefits;

	@OneToMany(mappedBy = "userCard", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Delivery> deliveries;

	@OneToMany(mappedBy = "userCard", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Purchase> purchases;

	@OneToMany(mappedBy = "userCard", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Charge> charges;

	@ColumnDefault("0")
	private Integer balance; // 카드잔액
	
	@ColumnDefault("0")
	private Integer discountAmount; // 받은 혜택 총액
	
	@ColumnDefault("0")
	private Integer rechargeCount; // 재충전 횟수
	
	@ColumnDefault("1")
	private Boolean status; // 카드 상태 1 : 사용, 0 : 해지 Y, N default
	
	@CreationTimestamp
	private LocalDateTime createdAt; // 카드 생성날짜
	private LocalDateTime expiredAt; // 만료날짜
	
	private Boolean isGroup; // Y, N
	
	private Long travelWithId;
	// 모임통장 삭제시 활성화된 user_card 주인들의
	// status를 전부 비활성화 시켜준다.
	@ColumnDefault("0")
	private Boolean isDefault; // Y, N 기본카드

}