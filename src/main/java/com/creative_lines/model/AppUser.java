package com.creative_lines.model;

import com.creative_lines.contains.db.DbConstants;
import com.creative_lines.contains.enums.Role;
import com.creative_lines.contains.enums.SubscriptionType;
import com.creative_lines.contains.enums.UserStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Map;

@Entity
@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(
        name = DbConstants.User.TABLE_NAME,
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_user_email", columnNames = {DbConstants.User.EMAIL})
        }
)
@SequenceGenerator(
        name = DbConstants.User.SEQUENCE_NAME,
        sequenceName = DbConstants.User.SEQUENCE_NAME,
        allocationSize = 1
)
public class AppUser extends AbstractBaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = DbConstants.User.SEQUENCE_NAME)
    @Column(name = DbConstants.User.ID)
    private Long id;

    @Column(name = DbConstants.User.EMAIL, unique = true)
    private String email;

    @Column(name = DbConstants.User.PASSWORD, nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = DbConstants.User.ROLE, nullable = false, columnDefinition = "varchar(255)")
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(name = DbConstants.User.STATUS, nullable = false, columnDefinition = "varchar(255)")
    private UserStatus userStatus;

    @Column(name = DbConstants.User.FIRST_NAME, columnDefinition = "varchar(50)")
    private String firstName;

    @Column(name = DbConstants.User.LAST_NAME, columnDefinition = "varchar(50)")
    private String lastName;


    @Column(name = DbConstants.User.PHONE)
    private String phone;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = DbConstants.User.PROFILE_IMAGE, columnDefinition = "jsonb")
    private Map<String, String> profileImage;

    @Enumerated(EnumType.STRING)
    @Column(name = DbConstants.User.SUBSCRIPTION_TYPE)
    private SubscriptionType subscriptionType;

}


