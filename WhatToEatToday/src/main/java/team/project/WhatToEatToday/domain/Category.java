package team.project.WhatToEatToday.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // db table과 일대일로 매칭되는 객체 단위
@Getter
@Setter
public class Category {

    @Id // PK 지정. 객체의 인스턴스를 구분하기 위한 유일한 key값
    @GeneratedValue // Auto increment
    @Column(name = "category_id") // 해당 멤버변수와 테이블의 column mapping
    private Long id;

    private String name;

    @ManyToMany // N:M join
    @JoinTable(name = "category_item", // N:N join에 해당하는 테이블 선언
            joinColumns = @JoinColumn(name = "category_id"), // join할 column 지정
            inverseJoinColumns = @JoinColumn(name = "item_id")) // join할 column 지정
    private List<Item> items = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY) // 해당 테이블을 기준으로 N:1 join에 사용. 
    // fetch:엔티티 로딩방식 결정 (EAGER: 연관된 엔티티 바로 로딩, LAZY: 실제 해당 객체를 조회할 때 해당 엔티티 로딩)
    @JoinColumn(name = "parent_id") // join할 column 지정
    private Category parent;

    @OneToMany(mappedBy = "parent") // 해당 테이블을 기준으로 1:N join에 사용. 값을 list로 가짐
    private List<Category> child = new ArrayList<>();

    //==연관관계 메서드==//
    public void addChildCategory(Category child) {
        this.child.add(child);
        child.setParent(this);
    }
}
