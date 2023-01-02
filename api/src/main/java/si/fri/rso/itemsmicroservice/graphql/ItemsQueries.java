package si.fri.rso.itemsmicroservice.graphql;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.kumuluz.ee.graphql.annotations.GraphQLClass;
import com.kumuluz.ee.graphql.classes.Filter;
import com.kumuluz.ee.graphql.classes.Pagination;
import com.kumuluz.ee.graphql.classes.PaginationWrapper;
import com.kumuluz.ee.graphql.classes.Sort;
import com.kumuluz.ee.graphql.utils.GraphQLUtils;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLQuery;
import si.fri.rso.itemsmicroservice.lib.Item;
import si.fri.rso.itemsmicroservice.services.beans.ItemBean;

@GraphQLClass
@ApplicationScoped
public class ItemsQueries {
    @Inject
    private ItemBean itemBean;

    @GraphQLQuery
    public PaginationWrapper<Item> getAllItems(@GraphQLArgument(name = "pagination") Pagination pagination,
            @GraphQLArgument(name = "sort") Sort sort,
            @GraphQLArgument(name = "filter") Filter filter) {

        return GraphQLUtils.process(itemBean.getItem(), pagination, sort, filter);
    }

    @GraphQLQuery
    public Item getItem(@GraphQLArgument(name = "itemId") Integer itemId) {
        return itemBean.getItem(itemId);
    }
}
