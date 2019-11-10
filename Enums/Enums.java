package com.Enums;

public class Enums {
    public enum Faculty{
        ИКС{
            @Override
            public String toString(){
                return "ИКС";
            }
        },
        ИБЭИТ{
            @Override
            public String toString(){
                return "ИБЭИТ";
            }
        },
        ИЕЕ{
            @Override
            public String toString(){
                return "ИЕЕ";
            }
        },
        ИБЭРТ{
            @Override
            public String toString(){
                return "ИБЭРТ";
            }
        },
        Неизвестно{
            @Override
            public String toString(){
                return "Неизвестно";
            }
        },
    }
}
