package masters.vlad.humeniuk.notesviper.domain.interactors;

import java.util.List;

import masters.vlad.humeniuk.notesviper.domain.entity.Category;
import io.reactivex.Observable;

public interface CategoriesListInteractor {

    Observable<List<Category>> getCategoriesList();
}
