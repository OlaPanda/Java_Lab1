package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.*;
import java.io.File;
import java.io.IOException;
import com.company.BackUp;
import com.company.University;
import com.company.Universiteis;
import com.company.Realization;
import com.company.Controllers.InputFullnameController;
import com.company.Controllers.InputNumberTelephoneController;
import com.company.Controllers.InputSurnameController;
public class Controller {
    private ObservableList<University> list = FXCollections.observableArrayList();

    @FXML
    private TableView<University> tableUniversity;

    @FXML
    private TableColumn<University, String> courseColumn;

    @FXML
    private TableColumn<University, String> cipherColumn;

    @FXML
    private TableColumn<University, String> facultyColumn;

    @FXML
    private TableColumn<University, String> groupColumn;

    @FXML
    private TableColumn<University, String> teacherColumn;

    @FXML
    private TableColumn<University, String> assistantColumn;

    @FXML
    private TableColumn<University, String> hoursForPracticeColumn;
    private static University university;

    @FXML
    private void initialize() {
        universiteis = new Universiteis();

        numberTelephoneColumn.setCellValueFactory(new PropertyValueFactory<PhoneNumber, String>("number"));
        fullNameColumn.setCellValueFactory(new PropertyValueFactory<PhoneNumber, String>("fullName"));
        adressColumn.setCellValueFactory(new PropertyValueFactory<PhoneNumber, String>("adress"));
        telephoneColumn.setCellValueFactory(new PropertyValueFactory<PhoneNumber, String>("telephone"));
        addToTable();
    }

    public static void BackUp() {
        BackUp backUp = new BackUp("University.bcp", universiteis);
        backUp.start();
    }

    private void addToTable() {
        list.addAll(universiteis.getList());
        tableUniversities.setItems(list);
    }

    private void refresh() {
        tableUniversities.getItems().clear();
        addToTable();
    }

    private String pathname = null;

    private boolean FileChooserOpen() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Открытие файла");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Текстовый документ", "*.txt", "*.ser", "*.bcp"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        Window mainStage = null;
        File selectedFile = fileChooser.showOpenDialog(mainStage);
        if (selectedFile != null) {
            pathname = selectedFile.toString();
            return true;
        } else {
            return false;
        }
    }

    private boolean FileChooserSave() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Сохранение файла");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Текстовый документ", "*.txt"),
                new FileChooser.ExtensionFilter("Сериализованный файл", "*.ser"),
                new FileChooser.ExtensionFilter("Резеврный файл", "*.bcp"));
        Window mainStage = null;
        File nameFile = fileChooser.showSaveDialog(mainStage);
        if (nameFile != null) {
            pathname = nameFile.toString();
            return true;
        } else {
            return false;
        }
    }

    public void openFile(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        boolean isWantSave = FileChooserOpen();
        if (isWantSave) {
            Realization realization = new Realization(pathname);
            realization.Deserialization(universities);
            refresh();
        }
    }

    public void saveFile(ActionEvent actionEvent) throws IOException {
        boolean isWantSave = FileChooserSave();
        if (isWantSave) {
            Realization realization = new Realization(pathname);
            realization.New(universiteis);
        }
    }

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void clearList(ActionEvent actionEvent) {
        universiteis.getList().clear();
        tableUniversiteis.getItems().clear();
        list.clear();
    }
/*
    public void changeAbonent(ActionEvent actionEvent){
        Main.inputNumberTelephone();
        if(InputNumberTelephoneController.number!=null&& !InputNumberTelephoneController.IsCancel) {
            if(phoneNumbers.IsInList(InputNumberTelephoneController.number)) {
                Main.inputFullname();
                if (InputFullnameController.surname != null) {
                    phoneNumbers.reassignementOfOwnership(InputNumberTelephoneController.number, InputFullnameController.surname);
                    refresh();
                }
            }
            else {
                AlertInformation("Поиск номера", "Информация", "Такого номер не найден", Alert.AlertType.INFORMATION);
            }
        }
    }

    public void findByNumber(ActionEvent actionEvent){
        Main.inputNumberTelephone();
        if(InputNumberTelephoneController.number!=null&& !InputNumberTelephoneController.IsCancel){
            if(phoneNumbers.IsInList(InputNumberTelephoneController.number)) {
                list.setAll(phoneNumbers.getDataByNumber(InputNumberTelephoneController.number));
                if(list.size()==0) {
                    AlertInformation("Поиск абонента по фамилии", "Информация", "Такого абонента нет в базе", Alert.AlertType.INFORMATION);
                }
            }
        }
    }

    public void findBySurname(ActionEvent actionEvent){
        Main.inputSurname();
        if(InputSurnameController.surname!=null && !InputSurnameController.IsCancel) {
            list.setAll(phoneNumbers.getDataBySurname(InputSurnameController.surname));
            if(list.size()==0){
                AlertInformation("Поиск абонента по фамилии", "Не найдено", "Такого абонента нет в базе", Alert.AlertType.INFORMATION);
            }
        }
    }

    public void listOfAvailableAbonents(ActionEvent actionEvent){
        list.setAll(phoneNumbers.listOfAvailableNumbers());
    }

    public void printList(ActionEvent actionEvent){
        list.setAll(phoneNumbers.getList());
    }

    public void about(ActionEvent actionEvent){
        AlertInformation("О программе", "Лицензия:", "Все права на лицензию принадлежат компании ToCMaH 2019©", Alert.AlertType.INFORMATION);
    }

    public void addToList(ActionEvent actionEvent) {
        Main.inputNumberTelephone();
        if(InputNumberTelephoneController.number!=null && !InputNumberTelephoneController.IsCancel) {
            if(phoneNumbers.addToList(InputNumberTelephoneController.number)!=null) {
                list.add(phoneNumbers.getList().get(phoneNumbers.getList().size() - 1));
            } else {
                AlertInformation("Добавление номера в список", "Номер уже существует", "Такой номер уже существует в базе, проверьте правильность ввода!", Alert.AlertType.INFORMATION);
            }
        }
    }

    public void removeOfList(ActionEvent actionEvent) {
        Main.inputNumberTelephone();
        if(InputNumberTelephoneController.number!=null && !InputNumberTelephoneController.IsCancel) {
            PhoneNumber phoneNumber = phoneNumbers.removeOfList(InputNumberTelephoneController.number);
            if ((phoneNumber != null)) {
                list.remove(phoneNumber);
            } else {
                AlertInformation("Удаление номера из списка", "Номер не найден", "Такой номер не найден в базе, проверьте правильность ввода!", Alert.AlertType.INFORMATION);
            }
        }
    }

    private void AlertInformation(String title, String header, String content, Alert.AlertType typeAlert){
        Alert alert = new Alert(typeAlert);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

*/
}

