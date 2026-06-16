package com.vti.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "group_account")
@IdClass(GroupAccountId.class) // Kết nối với file ID ở trên
@Data
public class GroupAccount {

    @Id
    @Column(name = "group_id")
    private Integer groupId; //

    @Id
    @Column(name = "account_id")
    private Integer accountId;


    @ManyToOne
    @JoinColumn(name = "group_id", insertable = false, updatable = false)
    private Group group;

    @ManyToOne
    @JoinColumn(name = "account_id", insertable = false, updatable = false)
    private Account account;

    @Column(name = "join_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date joinDate;
}