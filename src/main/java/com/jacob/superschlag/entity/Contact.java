package com.jacob.superschlag.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    @Id
    private long id;

    @ManyToOne
    private User requesterUserId;

    @OneToOne
    private User addresseeUserId;

    @Enumerated(EnumType.STRING)
    private ContactStatus contactStatus;
}
