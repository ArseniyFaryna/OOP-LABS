package org.example;

public class FinalizationHandler extends ClearenceHandler {

    private final NotificationService notificationService;

    public FinalizationHandler(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Override
    protected void process(ClearenceRequest request) {
        notificationService.notify("Your documents are OK, you can see your final price -> ");
    }
}
