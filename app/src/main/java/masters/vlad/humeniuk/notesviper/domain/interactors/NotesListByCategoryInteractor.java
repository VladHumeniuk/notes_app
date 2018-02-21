package masters.vlad.humeniuk.notesviper.domain.interactors;

import java.util.List;

import masters.vlad.humeniuk.notesviper.domain.entity.Category;
import masters.vlad.humeniuk.notesviper.domain.entity.Note;
import io.reactivex.Observable;

public interface NotesListByCategoryInteractor {

    Observable<List<Note>> getNotesListByCategory(Category category);
}
