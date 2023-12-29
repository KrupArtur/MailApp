package com.test.jfx;

import com.test.jfx.controller.services.FeatchFoldersService;
import com.test.jfx.model.EmailAccount;
import com.test.jfx.model.EmailTreeItem;
import javafx.scene.control.TreeItem;

public class EmailManager {
    //Folder handling:
    private EmailTreeItem<String> foldersRoot = new EmailTreeItem<String>("");

    public EmailTreeItem<String> getFoldersRoot() {
        return foldersRoot;
    }

    public void addEmailAccount(EmailAccount emailAccount){
        EmailTreeItem<String> treeItem = new EmailTreeItem<>(emailAccount.getAddress());
        FeatchFoldersService featchFoldersService = new FeatchFoldersService(emailAccount.getStore(), treeItem);
        featchFoldersService.start();
        foldersRoot.getChildren().add(treeItem);
    }
}
