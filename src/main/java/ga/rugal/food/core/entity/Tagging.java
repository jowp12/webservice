package ga.rugal.food.core.entity;

import com.google.gson.annotations.Expose;
import config.SystemDefaultProperties;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Rugal Bernstein
 */
@Entity
@Table(schema = "food", name = "tagging")
public class Tagging
{

    private static final String sequence_name = "tagging_gid_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = sequence_name)
    @SequenceGenerator(name = sequence_name, sequenceName = SystemDefaultProperties.SCHEMA + sequence_name, allocationSize = 1)
    @Basic(optional = false)
    @Column(nullable = false)
    @Expose
    private Long gid;

    @Column(nullable = false)
    private Integer weight = 1;

    @JoinColumn(name = "mid", referencedColumnName = "mid")
    @ManyToOne
    private Menu menu;

    @JoinColumn(name = "rid", referencedColumnName = "rid")
    @ManyToOne
    private Restaurant restaurant;

    @JoinColumn(name = "cid", referencedColumnName = "cid")
    @ManyToOne
    private Client client;

    @JoinColumn(name = "tid", referencedColumnName = "tid")
    @ManyToOne
    private Tag tag;

    public Tagging()
    {
    }

    public Tagging(Long gid)
    {
        this.gid = gid;
    }

    public Long getGid()
    {
        return gid;
    }

    public Tagging setGid(Long gid)
    {
        this.gid = gid;
        return this;
    }

    public Integer getWeight()
    {
        return weight;
    }

    public Tagging setWeight(Integer weight)
    {
        this.weight = weight;
        return this;
    }

    public Menu getMenu()
    {
        return menu;
    }

    public Tagging setMenu(Menu menu)
    {
        this.menu = menu;
        return this;
    }

    public Restaurant getRestaurant()
    {
        return restaurant;
    }

    public Tagging setRestaurant(Restaurant restaurant)
    {
        this.restaurant = restaurant;
        return this;
    }

    public Tag getTag()
    {
        return tag;
    }

    public Tagging setTag(Tag tag)
    {
        this.tag = tag;
        return this;
    }

    public Client getClient()
    {
        return client;
    }

    public Tagging setClient(Client client)
    {
        this.client = client;
        return this;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (gid != null ? gid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tagging))
        {
            return false;
        }
        Tagging other = (Tagging) object;
        return !((this.gid == null && other.gid != null) || (this.gid != null && !this.gid.equals(other.gid)));
    }

    @Override
    public String toString()
    {
        return "ga.rugal.food.core.entity.Tagging[ gid=" + gid + " ]";
    }

}
