package masters.vlad.humeniuk.notesviper.domain.interactors;

import masters.vlad.humeniuk.notesviper.domain.entity.Category;
import io.reactivex.Observable;

public interface AddCategoryInteractor {

    Observable<Category> addCategory(Category category);
}
