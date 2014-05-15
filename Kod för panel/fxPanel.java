private static JFXPanel fxPanel;
    
    public DemoTopComponent() {
        initComponents();
        setName(Bundle.CTL_DemoTopComponent());
        setToolTipText(Bundle.HINT_DemoTopComponent());
        setLayout(new BorderLayout());
        init();
       
    }

    public void init() {
        fxPanel = new JFXPanel();
        add(fxPanel, BorderLayout.CENTER);
        Platform.setImplicitExit(false);
        Platform.runLater(new Runnable() {
        @Override
        public void run() {
            createScene();
        }
    });
    }
    
    private void createScene() {
        // We are manipulating JavaFx content
        // so we must be in the JavaFX Application Thread.
        StackPane pane = new StackPane();
        
        // Create a DropShadow effect
        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0f);
        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
        
        // Create a rounded Rectangle & add it to the stackpane
        Rectangle r = new Rectangle(400, 60,
        Color.LIGHTSKYBLUE);
        r.setArcHeight(20);
        r.setArcWidth(20);
        r.setEffect(ds);
        pane.getChildren().add(r);
        
        // Create a text object & add it to the stackpane
        Text t = new Text();
        t.setEffect(ds);
        t.setCache(true);
        t.setFill(Color.DARKSLATEGRAY);
        t.setText("Test");
        t.setFont(Font.font(null, FontWeight.BOLD, 32));
        pane.getChildren().add(t);
        
        // set the JFXPanel's scene
        fxPanel.setScene(new Scene(pane));
        
    }