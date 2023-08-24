package com.LucaSteam.controller.error;

public class GameNotFoundException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        public GameNotFoundException() {
            super("Epic Fail: No existe el juego");
        }
        public GameNotFoundException(Long id) {
            super("Epic Fail: No existe el juego "+id);
        }
}
