package masters.vlad.humeniuk.notesviper.presentation.main.presenter;

import android.content.Intent;

public interface MainPresenter {

    void onNotesListClick();

    void onCategoriesClick();

    void init();

    void onActivityResult(int requestCode, int resultCode, Intent data);
}
