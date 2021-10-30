
/*
 * Copyright (c) 2021 Karina Ayabire-Ayabire <karina.ayabire@hotmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.google.codelabs.mdc.java.shrine;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


/**
 * @author Karina Ayabire Ayabire
 */
public class MainActivity extends AppCompatActivity implements NavigationHost {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.shr_main_activity);

    if (savedInstanceState == null) {
      getSupportFragmentManager()
          .beginTransaction()
          .add(R.id.container, new LoginFragment())
          .commit();
    }
  }

  /**
   * Navigate to the given fragment.
   *
   * @param fragment       Fragment to navigate to.
   * @param addToBackstack Whether or not the current fragment should be added to the backstack.
   */
  @Override
  public void navigateTo(Fragment fragment, boolean addToBackstack) {
    FragmentTransaction transaction =
        getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.container, fragment);

    if (addToBackstack) {
      transaction.addToBackStack(null);
    }

    transaction.commit();
  }
}
