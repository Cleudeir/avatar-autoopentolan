
                # Events.java                
                ## project structure
                ```                    
                avatar-autoopentolan/
    README.md
    mine.xlsx
    build.gradle
    LICENSE.txt
    gradlew
    changelog.txt
    settings.gradle
    CREDITS.txt
    gradle.properties
    gradlew.bat
    src/
        main/
            java/
                com/
                    avatar/
                        autoopentolan/
                            GlobalConfig.java
                            Main.java
                            server/
                                Events.java
            resources/
                pack.mcmeta
                META-INF/
                    mods.toml
    gradle/
        wrapper/
            gradle-wrapper.jar
            gradle-wrapper.properties                
                ```
                ## Sumário

Este projeto é um mod para Minecraft Forge que automatiza a abertura de um servidor LAN, permitindo configurar a porta e o status PvP.  Ele designa o primeiro jogador como "hoster" e permite alternar entre os modos de jogo Sobrevivência e Espectador usando a tecla Escape.  O mod utiliza eventos do Forge para gerenciar o status LAN, carregar configurações e lidar com a entrada do jogador.  As dependências incluem o Minecraft Forge e possivelmente outras bibliotecas Java, dependendo da implementação. A arquitetura baseia-se no sistema de eventos do Forge. A pipeline envolve a inicialização do servidor, a configuração da LAN, a atribuição do hospedeiro e o tratamento de eventos de entrada do teclado para alternar o modo de jogo.
                
                