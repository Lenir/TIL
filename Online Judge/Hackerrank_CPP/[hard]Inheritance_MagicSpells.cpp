/*
 * hackerrank_MagicSpells.cpp
 *
 *  Created on: 2018. 2. 7.
 *      Author: Ciel
 */

#import <iostream>
#import <vector>
#import <string>

using namespace std;


class Spell {
    private:
        string scrollName;
    public:
        Spell(): scrollName("") { }
        Spell(string name): scrollName(name) { }
        virtual ~Spell() { }
        string revealScrollName() {
            return scrollName;
        }
};

class Fireball : public Spell {
    private: int power;
    public:
        Fireball(int power): power(power) { }
        void revealFirepower(){
            cout << "Fireball: " << power << endl;
        }
};

class Frostbite : public Spell {
    private: int power;
    public:
        Frostbite(int power): power(power) { }
        void revealFrostpower(){
            cout << "Frostbite: " << power << endl;
        }
};

class Thunderstorm : public Spell {
    private: int power;
    public:
        Thunderstorm(int power): power(power) { }
        void revealThunderpower(){
            cout << "Thunderstorm: " << power << endl;
        }
};

class Waterbolt : public Spell {
    private: int power;
    public:
        Waterbolt(int power): power(power) { }
        void revealWaterpower(){
            cout << "Waterbolt: " << power << endl;
        }
};

class SpellJournal {
    public:
        static string journal;
        static string read() {
            return journal;
        }
};
string SpellJournal::journal = "";

int findSubstr(string spell, string journal){
	int m=spell.length();
	int n=journal.length();
	int array[m+1][n+1];

	// solve for LCS
	for (int i=0;i<=m;i++) array[i][0]=0;
	for (int j=0;j<=n;j++) array[0][j]=0;
	for (int i=1;i<=m;i++) {
		for (int j=1;j<=n;j++) {
			if (spell[i-1] == journal[j-1])
				array[i][j]=array[i-1][j-1]+1;
			else
				array[i][j]=max(array[i][j-1],array[i-1][j]);
		}
	}
	return array[m][n];

}

void counterspell(Spell *spell) {
	  /* Enter your code here */
	Fireball *fire;
	Frostbite *frost;
	Waterbolt *water;
	Thunderstorm *thunder;
	if((fire = dynamic_cast<Fireball*>(spell)) != NULL ){
		fire->revealFirepower();
	}else if((frost = dynamic_cast<Frostbite*>(spell)) != NULL ){
		frost->revealFrostpower();
	}else if((water = dynamic_cast<Waterbolt*>(spell)) != NULL ){
		water->revealWaterpower();
	}else if((thunder = dynamic_cast<Thunderstorm*>(spell)) != NULL ){
		thunder->revealThunderpower();
	}else{
		cout<<findSubstr(SpellJournal::journal, (*spell).revealScrollName())<<endl;
	}

}

class Wizard {
    public:
        Spell *cast() {
            Spell *spell;
            string s; cin >> s;
            int power; cin >> power;
            if(s == "fire") {
                spell = new Fireball(power);
            }
            else if(s == "frost") {
                spell = new Frostbite(power);
            }
            else if(s == "water") {
                spell = new Waterbolt(power);
            }
            else if(s == "thunder") {
                spell = new Thunderstorm(power);
            }
            else {
                spell = new Spell(s);
                cin >> SpellJournal::journal;
            }
            return spell;
        }
};

int main_magic() {
    int T;
    cin >> T;
    Wizard Arawn;
    while(T--) {
        Spell *spell = Arawn.cast();
        counterspell(spell);
    }
    return 0;
}

