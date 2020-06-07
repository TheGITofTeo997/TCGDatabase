package it.unibs.db.tcg.controller;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import it.unibs.db.tcg.model.*;
import it.unibs.db.tcg.view.*;

public class Controller {

	private ModelGod model;

	/* View components */
	private JFrame frame;
	private AccountPanel acPan = null;
	private HomePanel homePan = null;
	private LoginPanel logPan = null;
	private SearchPanel srcPan = null;
	private CardsPanel crdsPan = null;
	private CartaPanel carPan = null;
	private EditPanel edPan = null;

	public Controller() {
		model = new ModelGod();
	}

	public void buildFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new JFrame("TCG Database");
					frame.setResizable(false);
					frame.setBounds(0, 0, 800, 600);
					frame.setLocationRelativeTo(null);
					frame.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent e) {
							System.exit(0);
						}
					});
					frame.getContentPane().setLayout(null);
					frame.setVisible(true);
					drawLoginPanel();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void drawLoginPanel() {
		logPan = new LoginPanel();
		logPan.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(logPan);
		logPan.addHomeListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (logPan.getLoginField().equals(null) || !model.isUserExistant(logPan.getLoginField()))
					logPan.showErrorPopup();
				else {
					logPan.setVisible(false);
					Utente user = model.getUser(logPan.getLoginField());
					user.setCollections(model.getUserCollections(user.getNickname()));
					drawHomePanel(user);
				}
			}
		});
	}

	public void drawHomePanel(Utente user) {
		homePan = new HomePanel();
		homePan.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(homePan);

		homePan.setAvatar(user.getAvatar());
		homePan.setNickname(user.getNickname());

		homePan.addAccountListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				homePan.setVisible(false);
				user.setTotalCardsValue(model.getUserTotalCardsValue(user.getNickname()));
				drawAccountPanel(user);
			}
		});

		homePan.addBackListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (homePan.showConfirmDialog() == 0) {
					homePan.setVisible(false);
					drawLoginPanel();
				}
			}
		});
		
		homePan.addSearchListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					homePan.setVisible(false);
					drawSearchPanel(user);
				
			}
		});
	}

	public void drawAccountPanel(Utente user) {
		acPan = new AccountPanel();
		acPan.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(acPan);
		acPan.setNickname(user.getNickname());
		acPan.setMail(user.getMail());
		acPan.setAvatar(user.getAvatar());
		acPan.setUserName(user.getNomeUtente());
		acPan.setRegistrationDate(user.getDataRegistrazione().toString());
		acPan.setTotalValue(user.getTotalCardsValue());
		acPan.setCollections(user.getDefaultListModelCollections());

		acPan.addCollectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					String collection = user.getDefaultListModelCollections().get(acPan.getListSelectedIndex());
					Collezione c = new Collezione(collection);
					c.setCarteCollezione(model.getCardsFromCollection(user.getNickname(), collection));
					acPan.setVisible(false);
					drawCardsPanel(user, "Carte della Collezione " + collection, c.getCardsList());
				}
			}
		});

		acPan.addEditListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				acPan.setVisible(false);
				drawEditPanel(user);
			}
		});

		acPan.addBackListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				acPan.setVisible(false);
				drawHomePanel(user);
			}
		});

	}

	public void drawEditPanel(Utente user) {
		edPan = new EditPanel();
		edPan.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(edPan);
		edPan.setNickname(user.getNickname());
		edPan.setUserName(user.getNomeUtente());
		edPan.setMail(user.getMail());
		edPan.setName(user.getNomeUtente());
		edPan.setAvatar(user.getAvatar());

		edPan.addEditNameListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String result = edPan.showEditPopup();
				if (result != null) {
					if (result.matches(Strings.USERNAME_REGEX) && result.length() > 2) {
						model.updateUserName(user.getNickname(), result);
						user.setNomeUtente(result);
						edPan.setUserName(result);
						edPan.showCorrectPopup();
					} else
						edPan.showErrorPopup();
				}
			}
		});

		edPan.addEditMailListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String result = edPan.showEditPopup();
				if (result != null) {
					Pattern p = Pattern.compile(Strings.MAIL_REGEX, Pattern.CASE_INSENSITIVE);
					Matcher matcher = p.matcher(result);
					if(matcher.find()) {
						model.updateMail(user.getNickname(), result);
						user.setMail(result);
						edPan.setMail(result);
						edPan.showCorrectPopup();
					}else
						edPan.showErrorPopup();
				}

			}
		});

		edPan.addEditAvatarListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String result = edPan.showEditPopup();
			}
		});

		edPan.addBackListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				edPan.setVisible(false);
				drawAccountPanel(user);
			}
		});
	}

	public void drawCardsPanel(Utente user, String title, List<Carta> cardsName) {
		crdsPan = new CardsPanel();
		crdsPan.setBounds(0, 0, 800, 600);
		crdsPan.setTitleText(title);
		crdsPan.setCardList(cardsName);
		frame.getContentPane().add(crdsPan);

		crdsPan.addCardListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					Carta c = cardsName.get(crdsPan.getListSelectedIndex());
					Carta card = model.getCardFromNumberAndAbbrEspansione(c.getNumero(), c.getAbbrEspansione());
					crdsPan.setVisible(false);
					drawCartaPanel(user, title, cardsName, card);
				}
			}
		});

		crdsPan.addBackListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				crdsPan.setVisible(false);
				drawAccountPanel(user);
			}
		});
	}

	public void drawCartaPanel(Utente user, String title, List<Carta> cardsName, Carta c) {
		carPan = new CartaPanel();
		carPan.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(carPan);

		String cardType = model.getCardType(c.getNumero(), c.getAbbrEspansione());
		switch (cardType) {
		case Strings.CARTA_POKEMON_BASE:
			carPan.setSpecsCartaPokemon((CartaPokemonBase) c);
			break;
		case Strings.CARTA_POKEMON_SPECIALE:
			carPan.setSpecsCartaPokemon((CartaPokemonSpeciale) c);
			break;
		case Strings.CARTA_STRUMENTO:
			carPan.setSpecsCartaStrumento((CartaStrumento) c);
			break;
		case Strings.CARTA_ENERGIA:
			carPan.setSpecsCartaEnergia((CartaEnergia) c);
			break;

		}

		carPan.addBackListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				carPan.setVisible(false);
				drawCardsPanel(user, title, cardsName);
			}
		});

	}
	
	public void drawSearchPanel(Utente user) {
		srcPan = new SearchPanel();
		srcPan.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(srcPan);
		
		srcPan.addBackListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				srcPan.setVisible(false);
				drawHomePanel(user);
			}
		});
		
		srcPan.addUserSearchListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = srcPan.getUserNameField();
				//do things ....
			}
		});
		
		srcPan.addCardSearchListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String cardName = srcPan.getCardNameField();
				String exp = srcPan.getCardExpField();
				String cardIllustrator = srcPan.getCardIllustratorField();
				int lowerPSValue = srcPan.getPSBarLowerValue();
				int upperPSValue = srcPan.getPSBarUpperValue();
				int lowerValueBarValue = srcPan.getValueBarLowerValue();
				int upperValueBarValue = srcPan.getValueBarUpperValue();
				List<String> cardType = srcPan.getCardTypeSelected();
				List<String> energyType = srcPan.getEnergyTypeSelected();
				List<String> rarityType = srcPan.getRaritySelected();
				//if cardType.size == 0, non bisogna fare query
				//if energyType.size == 0, non bisogna fare query ecc...
				//if rarityType.size == 0, non bisogna fare query ecc...
				//Fare le query singole ed intersecare i risultati
				//List<Carta> carte_trovate = model.(....);
				//drawCardPanel(user, "carte trovate", carte_trovate);
				
				
			}
		});
	}

}
