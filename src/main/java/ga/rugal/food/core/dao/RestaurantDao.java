package ga.rugal.food.core.dao;

import ga.rugal.food.core.entity.Restaurant;
import java.util.List;
import ml.rugal.sshcommon.hibernate.Updater;
import ml.rugal.sshcommon.page.Pagination;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Rugal Bernstein
 */
public interface RestaurantDao
{

    Restaurant deleteById(Integer id);

    @Transactional(readOnly = true)
    Restaurant getByID(Integer id);

    @Transactional(readOnly = true)
    Pagination getPage(int pageNo, int pageSize);

    Restaurant save(Restaurant bean);
    
    @Transactional(readOnly = true)
    List<Restaurant> getByAddress(String address);

    Restaurant updateByUpdater(Updater<Restaurant> updater);
}
