package masters.vlad.humeniuk.notesviper.presentation.createnote.view;

import masters.vlad.humeniuk.notesviper.domain.entity.Category;

public interface CreateNoteView {

    void showEmptyFieldsError();

    void showDefaultCategory(Category category);
}
