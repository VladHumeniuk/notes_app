package masters.vlad.humeniuk.notesviper.presentation.categories.presenter;

import android.util.Log;

import io.reactivex.Scheduler;
import masters.vlad.humeniuk.notesviper.domain.entity.Category;
import masters.vlad.humeniuk.notesviper.domain.interactors.CategoriesListInteractor;
import masters.vlad.humeniuk.notesviper.presentation.base.RxPresenter;
import masters.vlad.humeniuk.notesviper.presentation.categories.router.CategoriesListRouter;
import masters.vlad.humeniuk.notesviper.presentation.categories.view.CategoriesListView;

public class CategoriesListPresenterImpl extends RxPresenter implements CategoriesListPresenter {

    private static final int LOAD_CATEGORIES = 1;

    private Scheduler ioScheduler;
    private Scheduler uiScheduler;

    private CategoriesListRouter router;
    private CategoriesListView view;

    private CategoriesListInteractor categoriesListInteractor;

    public CategoriesListPresenterImpl(Scheduler ioScheduler,
                                       Scheduler uiScheduler,
                                       CategoriesListRouter router,
                                       CategoriesListInteractor categoriesListInteractor) {
        this.ioScheduler = ioScheduler;
        this.uiScheduler = uiScheduler;
        this.router = router;
        this.categoriesListInteractor = categoriesListInteractor;
    }

    @Override
    public void onCategorySelected(Category category) {
        router.showCategoryNotes(category);
    }

    @Override
    public void onCategoryLongClick(Category category) {
        router.showEditCategory(category);
    }

    @Override
    public void onAddCategoryClick() {
        router.showAddCategory();
    }

    @Override
    public void init() {
        subscribe(LOAD_CATEGORIES, categoriesListInteractor.getCategoriesList()
                .subscribeOn(ioScheduler)
                .observeOn(uiScheduler)
                .subscribe(list -> view.showCategories(list),
                        throwable -> Log.d("error", throwable.getMessage())));
    }

    @Override
    public void setView(CategoriesListView view) {
        this.view = view;
    }
}
