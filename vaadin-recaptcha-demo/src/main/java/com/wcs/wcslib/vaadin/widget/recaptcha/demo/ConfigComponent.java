/*
 * Copyright 2013 kumm.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.wcs.wcslib.vaadin.widget.recaptcha.demo;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Layout;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import java.util.Arrays;

/**
 *
 * @author kumm
 */
public class ConfigComponent extends CustomComponent {

    private HorizontalLayout compositionRoot;
    private NativeSelect themeSelect;
    private NativeSelect typeSelect;
    private NativeSelect sizeSelect;
    private TextField langField;

    public ConfigComponent() {
        compositionRoot = new HorizontalLayout();
        compositionRoot.setSpacing(true);
        setCompositionRoot(compositionRoot);
        buildComponent();
    }

    public String getTheme() {
        return (String) themeSelect.getValue();
    }

    public String getType() {
        return (String) typeSelect.getValue();
    }

    public String getSize() {
        return (String) sizeSelect.getValue();
    }

    public String getLang() {
        return langField.getValue();
    }

    private void buildComponent() {
        compositionRoot.addComponent(createThemeconfLayout());
        compositionRoot.addComponent(createTypeconfLayout());
        compositionRoot.addComponent(createSizeconfLayout());
        compositionRoot.addComponent(createLangconfLayout());
    }

    private Layout createThemeconfLayout() {
        Layout themeLayout = new FormLayout();
        themeSelect = new NativeSelect("theme", Arrays.asList("light", "dark"));
        themeSelect.setImmediate(true);
        themeSelect.setValue("light");
        themeLayout.addComponent(themeSelect);
        return themeLayout;
    }

    private Layout createTypeconfLayout() {
        Layout typeLayout = new FormLayout();
        typeSelect = new NativeSelect("type", Arrays.asList("image", "audio"));
        typeSelect.setImmediate(true);
        typeSelect.setValue("image");
        typeLayout.addComponent(typeSelect);
        return typeLayout;
    }

    private Layout createSizeconfLayout() {
        Layout sizeLayout = new FormLayout();
        sizeSelect = new NativeSelect("size", Arrays.asList("normal", "compact"));
        sizeSelect.setImmediate(true);
        sizeSelect.setValue("normal");
        sizeLayout.addComponent(sizeSelect);
        return sizeLayout;
    }

    private Layout createLangconfLayout() throws FieldGroup.BindException {
        VerticalLayout langLayout = new VerticalLayout();
        langField = new TextField("lang");
        langLayout.addComponent(new FormLayout(langField));

        return langLayout;
    }

}
