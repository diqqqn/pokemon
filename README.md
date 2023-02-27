# pokemon
Final project
Покемон
Да се направи уеб приложение на Spring Boot с база данни - копие на класическите покемон игри. Играчът е треньор на покемони и участва в битки от които печели различни награди или покемони. Играта има пет битки. Потребителя в началото си избира три покемона (от поне 10 възможни) и влиза в турнир. Има пет кръга, на всеки кръг се бие с 1 покемон. Всеки покемон има някакви статистики и атаки. Битката е на ходове, потребителя избира коя атака да използва на покемона или да смени покемона.
Играта трябва да може:
Да има управление на покемоните на играчът: добавяне на нови, обновяване и изтриване на съществуващи покемони
Да има управление на покемоните за компютъра: добавяне на нови, обновяване и изтриване на съществуващи покемони
Всеки покемон има точки живот, точки атака и точки защита. Също така има име, външен вид, тип, размер (малък, нормален, голям).
Всички покемони си имат дефолтни точки живот, атака и защита, но ако са малки или големи, точките съответно намаляват или се увеличават с до 20%.
Битката протича на ходове като пръв атакува чуждият покемон. Колко точки живот ще му вземе при атака зависи от: коя атака е използвана, точките защита на вашия покемон, точките атака на чуждия, типа на покемоните.
Битката продължава докато чуждият покемон не умре или докато всички ваши не умрат.
При победа получавате кристали. Те са крайнит ви резултат от турнира, но могат и да бъдат използвани за възвръщане на живота на покемоните ви.
При загуба - губите играта.
----
To make a Spring Boot web application with a database - a copy of the classic Pokemon games. The player is a Pokémon trainer and participates in battles from which he wins various prizes or Pokémon. The game has five battles. The user initially chooses three Pokemon (from at least 10 possible) and enters a tournament. There are five rounds, each round you battle 1 Pokemon. Each Pokemon has some stats and attacks. The battle is turn based, the user chooses which attack to use on the pokemon or switch pokemon.
The game must be able to:
1.Have management of the player's Pokemon: adding new, updating and deleting existing Pokemon
2.Have Pokemon management for PC: add new, update and delete existing Pokemon
3.Each pokemon has life points, attack points and defense points. It also has a name, appearance, type, size (small, normal, large).
4.All Pokemon have default health, attack and defense points, but if they are small or large, the points are reduced or increased by up to 20% accordingly.
5.The battle takes place in turns with the foreign Pokemon attacking first. How many life points it will take from an attack depends on: which attack is used, the defense points of your pokemon, the attack points of the other one, the type of pokemon.
6.The battle continues until the other person's Pokemon dies or until all of your Pokemon die.
7.When you win, you get crystals. They are your ultimate tournament score, but can also be used to restore your Pokemon's health.
8.If you lose, you lose the game.
