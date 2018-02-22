package masters.vlad.humeniuk.notesviper.presentation.categories.router;

import masters.vlad.humeniuk.notesviper.R;
import masters.vlad.humeniuk.notesviper.domain.entity.Category;
import masters.vlad.humeniuk.notesviper.presentation.base.BaseActivity;
import masters.vlad.humeniuk.notesviper.presentation.base.BaseRouter;
import masters.vlad.humeniuk.notesviper.presentation.createcategory.CreateCategoryActivity;

public class CategoriesListRouterImpl extends BaseRouter implements CategoriesListRouter {

    public static final int REQUEST_ADD_CATEGORY = 13;

    public CategoriesListRouterImpl(BaseActivity activity) {
        super(activity, R.id.fragment_container);
    }

    @Override
    public void showCategoryNotes(Category category) {
        //TODO
    }

    @Override
    public void showAddCategory() {
        startActivityForResult(CreateCategoryActivity.newIntent(getActivityContext()),
                REQUEST_ADD_CATEGORY);
    }

    @Override
    public void showEditCategory(Category category) {
        //TODO
    }
}
