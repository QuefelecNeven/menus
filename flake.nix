{
  description = "Environnement de développement Java pour le projet Menus";

  inputs = {
    nixpkgs.url = "github:NixOS/nixpkgs/nixos-unstable";
  };

  outputs = { self, nixpkgs }:
    let
      system = "x86_64-linux"; # À modifier en "aarch64-linux" si tu es sur un processeur ARM
      pkgs = import nixpkgs { inherit system; };
    in
    {
      devShells.${system}.default = pkgs.mkShell {
        buildInputs = with pkgs; [
          jdk17        # Ton pom.xml précise la version 17
          maven        # Pour gérer les dépendances comme jUnit
          nixpkgs-fmt  # Pour formater ton code Nix
        ];

        shellHook = ''
          echo "☕ Environnement Java activé (JDK 17)"
          echo "Pour compiler : mvn compile"
          echo "Pour lancer les tests : mvn test"
        '';
      };
    };
}