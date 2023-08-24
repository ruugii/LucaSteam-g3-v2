package com.LucaSteam.controller.error;

public class GameNotFoundException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        /**
         * Constructs a GameNotFoundException with a default error message.
         */
        public GameNotFoundException() {
            super("Epic Fail: The game doesn't exist");
        }
        
        /**
         * Constructs a GameNotFoundException with a specific error message based on the game's ID.
         *
         * @param id The ID of the game that was not found.
         */
        public GameNotFoundException(Long id) {
            super("Epic Fail: The game doesn't exist "+id);
        }
}
