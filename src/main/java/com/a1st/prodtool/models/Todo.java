package com.a1st.prodtool.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author: Abderrahman Youabd aka: A1ST
 */

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    @Enumerated(EnumType.STRING)
    private StatusType status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
