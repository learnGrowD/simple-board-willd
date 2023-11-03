package org.simple_board_willd.db.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.simple_board_willd.db.BaseEntity;
import org.simple_board_willd.db.board.enums.BoardStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "board")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class BoardEntity extends BaseEntity {

    @Column(nullable = false)
    private Long userId;

    @Column(length = 100, nullable = false)
    private String boardName;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private BoardStatus status;

    private LocalDateTime postedAt;
}
