```plantuml
@startuml
!theme sunlust
title Vue 1 : Hiérarchie des personnages (Héritage)

abstract class Character {
  - life: int
  - maxLife: int
  - speed: int
  - armor: int
  - attack: int
  + dealDamage(target: Character)
  # isDead(): boolean
}

class Gear

class Aventurer {
  - inventory: ArrayList<Object>
  - gear: Gear
  - level: int
  - exp: int
}

abstract class Monster {
  - xpValue: int
  - level: int
}

class Human
class Elf
class Dwarf
class Orc { 
  - height: double 
  }
  
class Undead { 
  - resurrectionRate: double 
  }
class Tyranide { 
  - claws: int 
  }

' Relations d'Héritage
Character <|-- Aventurer
Character <|-- Monster

Aventurer <|-- Human
Aventurer <|-- Elf
Aventurer <|-- Dwarf

Monster <|-- Orc
Monster <|-- Undead
Monster <|-- Tyranide

' Relation de Composition
Aventurer *-- Gear

@enduml
```

```plantuml
@startuml
!theme sunlust
title Vue 2 : Les Builders (Design Pattern Builder)

' Définition des classes produits (doivent être définies pour la liaison)
class Human
class Elf
class Dwarf
class Orc
class Undead
class Tyranide

' Les Builders
class "AventurerBuilder" as AventurerBuilder {
  + life(value: int): AventurerBuilder
  + speed(value: int): AventurerBuilder
  + armor(value: int): AventurerBuilder
  + attack(value: int): AventurerBuilder
  + buildHuman(): Human
  + buildElf(): Elf ' <-- Corrigé
  + buildDwarf(): Dwarf
}

class "Orc.OrcBuilder" as OrcBuilder {
  + life(value: int): OrcBuilder
  + speed(value: int): OrcBuilder
  + armor(value: int): OrcBuilder
  + attack(value: int): OrcBuilder
  + xpValue(value: int): OrcBuilder
  + level(value: int): OrcBuilder
  + height(value: double): OrcBuilder
  + build(): Orc
}

class "Undead.UndeadBuilder" as UndeadBuilder {
  + life(value: int): UndeadBuilder
  + speed(value: int): UndeadBuilder
  + armor(value: int): UndeadBuilder
  + attack(value: int): UndeadBuilder
  + xpValue(value: int): UndeadBuilder
  + level(value: int): UndeadBuilder
  + resurrectionRate(value: double): UndeadBuilder ' <-- Corrigé
  + build(): Undead
}

class "Tyranide.TyranideBuilder" as TyranideBuilder {
  + life(value: int): TyranideBuilder
  + speed(value: int): TyranideBuilder
  + armor(value: int): TyranideBuilder
  + attack(value: int): TyranideBuilder
  + xpValue(value: int): TyranideBuilder
  + level(value: int): TyranideBuilder
  + claws(value: int): TyranideBuilder
  + build(): Tyranide
}

' Relations de Dépendance (Builders construisent des Produits)
AventurerBuilder ..> Human
AventurerBuilder ..> Elf
AventurerBuilder ..> Dwarf
OrcBuilder ..> Orc
UndeadBuilder ..> Undead
TyranideBuilder ..> Tyranide

@enduml
```

```plantuml
@startuml
!theme sunlust
title Vue 3 : Les Factories (Fabriques)

' Définition des classes produits et builder nécessaires (doivent être définies pour la liaison)
class AventurerBuilder
class Orc
class Undead
class Tyranide
class Human
class Elf
class Dwarf

class FactoryMonstre {
  + createMonster(type: String): Monster
  + createOrc(): Orc
  + createUndead(): Undead
  + createTyranide(): Tyranide
}

class AventurerFactory {
  + createAventurer(choice: int): Aventurer ' <-- Corrigé
}

' Relations de Dépendance (Factories créent des Produits/utilisent des Builders)
FactoryMonstre ..> Orc
FactoryMonstre ..> Undead
FactoryMonstre ..> Tyranide

AventurerFactory ..> AventurerBuilder
AventurerFactory ..> Human
AventurerFactory ..> Elf
AventurerFactory ..> Dwarf

@enduml
```

```plantuml
@startuml
!theme sunlust
title Vue 4 : Objets

abstract class Object
class Armor {
  - name: string
  - protection: int
}
class Gear {
  - weapon: Weapon
  - armor: Armor
}
class Potion
class Weapon {
  - name: string
  - power: int
}

Object <|-- Armor
Object <|-- Potion
Object <|-- Gear
Object <|-- Weapon



