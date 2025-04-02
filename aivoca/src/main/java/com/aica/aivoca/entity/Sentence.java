package com.aica.aivoca.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "sentence")
public class Sentence {
    @Id
    @Column(name = "sentence_id")
    private Long sentenceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sentence_list", nullable = false)
    private SentenceList sentenceList;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String sentence;

    @Builder
    public Sentence(Long sentenceId, SentenceList sentenceList, String sentence) {
        this.sentenceId = sentenceId;
        this.sentenceList = sentenceList;
        this.sentence = sentence;
    }
}