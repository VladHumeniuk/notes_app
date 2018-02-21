package masters.vlad.humeniuk.notesviper.presentation.categories.router;

import masters.vlad.humeniuk.notesviper.R;
import masters.vlad.humeniuk.notesviper.domain.entity.Category;
import masters.vlad.humeniuk.notesviper.presentation.base.BaseActivity;
import masters.vlad.humeniuk.notesviper.presentation.base.BaseRouter;

public class CategoriesListRouterImpl extends BaseRouter implements CategoriesListRouter {

    public CategoriesListRouterImpl(BaseActivity activity) {
        super(activity, R.id.fragment_container);
    }

    @Override
    public void showCategoryNotes(Category category) {
        //TODO
    }

    @Override
    public void showAddCategory() {
        //TODO
    }

    @Override
    public void showEditCategory(Category category) {
        //TODO
    }
}
