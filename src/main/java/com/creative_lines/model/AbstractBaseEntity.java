package com.creative_lines.model;

import com.creative_lines.contains.db.DbConstants;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

@Getter
@Setter
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public class AbstractBaseEntity <T>{

    @CreatedDate
    @Column(name = DbConstants.Common.CREATED_AT, updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(name = DbConstants.Common.UPDATED_AT)
    private Instant updatedAt;

    @CreatedBy
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = DbConstants.Common.CREATED_BY,
            updatable = false,
            foreignKey = @ForeignKey(name = "fk_app_user_created_by_id_app_user")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private AppUser createdBy;

    @LastModifiedBy
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = DbConstants.Common.UPDATED_BY,
            foreignKey = @ForeignKey(name = "fk_app_user_updated_by_id_app_user")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private AppUser updatedBy;
}
