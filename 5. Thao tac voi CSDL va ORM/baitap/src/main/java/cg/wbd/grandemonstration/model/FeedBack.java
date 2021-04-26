package cg.wbd.grandemonstration.model;

import javax.persistence.*;

@Entity
@Table(name = "feedback")
public class FeedBack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int rate;
    private String nameAuthor;
    private String content;
    private int quantityLike;

    public FeedBack(Long id, int rate, String nameAuthor, String content, int quantityLike) {
        this.id = id;
        this.rate = rate;
        this.nameAuthor = nameAuthor;
        this.content = content;
        this.quantityLike = quantityLike;
    }

    public FeedBack() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getQuantityLike() {
        return quantityLike;
    }

    public void setQuantityLike(int quantityLike) {
        this.quantityLike = quantityLike;
    }
}
