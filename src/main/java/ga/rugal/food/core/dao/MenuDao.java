package ga.rugal.food.core.dao;

import ga.rugal.food.core.entity.Menu;
import ga.rugal.food.core.entity.Restaurant;
import ga.rugal.food.core.entity.Tag;
import ml.rugal.sshcommon.hibernate.Updater;
import ml.rugal.sshcommon.page.Pagination;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Rugal Bernstein
 */
public interface MenuDao
{

    Menu save(Menu bean);

    Menu deleteById(Integer id);

    @Transactional(readOnly = true)
    Menu getByID(Integer id);

    @Transactional(readOnly = true)
    Pagination getPage(int pageNo, int pageSize);

    Menu updateByUpdater(Updater<Menu> updater);

    @Transactional(readOnly = true)
    int countTotal();

    /**
     * Count the total number of matched menus with a specific restaurant
     *
     * @param r
     *
     * @return Give the number of menus
     */
    @Transactional(readOnly = true)
    int countMenusByRestaurant(Restaurant r);

    /**
     * Get a menu randomly from all matched menus
     *
     * @param r
     *
     * @return Give the number of menus corresponding to the specific restaurant
     *         if the restaurant exist, otherwise return 0 as the count number.
     */
    @Transactional(readOnly = true)
    Menu getRandomMenuByRestaurant(Restaurant r);

    /**
     * Find a menu that match given tag and provided by restaurant.
     *
     * @param tag
     * @param restaurant
     *
     * @return
     */
    @Transactional(readOnly = true)
    Menu getRandomMenuByTagAndRestaurant(Tag tag, Restaurant restaurant);

    /**
     * Count the number of menu that not only has given tag but also provided from target
     * restaurant.
     *
     * @param tag
     * @param restaurant
     *
     * @return
     */
    @Transactional(readOnly = true)
    int countByTagAndRestaurant(Tag tag, Restaurant restaurant);

}
