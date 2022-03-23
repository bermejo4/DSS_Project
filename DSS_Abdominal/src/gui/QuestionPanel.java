package gui;

import dss_abdominal.Patient;

interface QuestionPanel {

    public void initComponents(MainWindow mainWindow, Patient patient);

    public void getQuestionValues();
}
