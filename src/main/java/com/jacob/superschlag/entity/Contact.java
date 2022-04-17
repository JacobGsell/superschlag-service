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
    @GeneratedValue
    private long id;

    @ManyToOne
    private User requesterUser;

    @OneToOne
    private User addresseeUser;

    @Enumerated(EnumType.STRING)
    private ContactStatus contactStatus;
}
