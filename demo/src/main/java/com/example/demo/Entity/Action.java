package com.example.demo.Entity;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "action")
@XmlRootElement
public class Action implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private Integer userId;

    @Basic(optional = false)
    @NotNull
    @Column(name = "game_id")
    private Integer gameId;

    @Basic(optional = false)
    @NotNull
    @Column(name = "action")
    private String action;



    public Action(){

    }

    public Action(Integer userId, Integer gameId,String action)
    {
        this.userId = userId;
        this.gameId = gameId;
        this.action = action;
    }
    public Action(Integer id){
        this.id = id;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof Action)) {
            return false;
        }
        Action other = (Action) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() {
        return "io.mycroftsolutions.mycroftsolutionswebapp.entity.Action[ id=" + id + " ]";
    }


}