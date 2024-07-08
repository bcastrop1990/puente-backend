package pe.gob.senasa.tupabpmhw.api.model;

public class Credencial {
    
    private final String login;
        private final String identityContext;
        private final String userDisplayName;

        public Credencial(String login, String identityContext, String userDisplayName) {
            this.login = login;
            this.identityContext = identityContext;
            this.userDisplayName = userDisplayName;
        }

        public String getIdentityContext() {
            return identityContext;
        }

        public String getLogin() {
            return login;
        }

        public String getUserDisplayName() {
            return userDisplayName;
        }    

        @Override
        public String toString() {
            return "Credencial{" + "login=" + login + ", identityContext=" + identityContext + ", userDisplayName=" + userDisplayName + '}';
        }
        
}
