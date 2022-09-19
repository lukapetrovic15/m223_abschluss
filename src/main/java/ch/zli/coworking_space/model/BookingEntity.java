package ch.zli.coworking_space.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "GAME")
public class BookingEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    @Type(type = "org.hibernate.type.UUIDCharType")
    UUID id = UUID.randomUUID();


    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private MemberEntity member;

    @Transient
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Schema(accessMode = Schema.AccessMode.WRITE_ONLY)
    private UUID member_id;


    @ManyToOne
    @JoinColumn(name = "place_id", nullable = false)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private PlaceEntity place;

    @Transient
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Schema(accessMode = Schema.AccessMode.WRITE_ONLY)
    private UUID place_id;


    @Column(name = "startDate", nullable = false)
    private Timestamp startDate;

    @Column(name = "endDate", nullable = false)
    private Timestamp endDate;

    @Column(name = "isAccepted", nullable = false)
    private Boolean isAccepted;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingEntity that = (BookingEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(member, that.member) && Objects.equals(member_id, that.member_id) && Objects.equals(place, that.place) && Objects.equals(place_id, that.place_id) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate) && Objects.equals(isAccepted, that.isAccepted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, member, member_id, place, place_id, startDate, endDate, isAccepted);
    }
}
