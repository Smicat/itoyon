package com.itoyon.mtpro.test.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * @Description: 扑克牌游戏
 * @author: Stone
 * @date: 2018年5月13日 上午8:49:09
 */
public class PlayCards {
	List<Card> cardsList;
	List<Card> newCardsList;
	List<Player> playerList;
	Map<Integer, String> faceMap;
	Map<Integer, String> pointMap;

	public static void main(String[] args) {
		PlayCards play = new PlayCards();
		System.out.println("-------------------创建扑克牌--------------------");
		play.createCards();
		System.out.println("-------------------创建扑克牌成功！--------------------");
		System.out.print("为：[");
		int count = 0;
		for (Card card : play.cardsList) {
			System.out.print(card.id + ":" + card.name);
			if (count < play.cardsList.size() - 1) {
				System.out.print(", ");
			}
			count++;
		}
		System.out.print("]");

		System.out.println();
		System.out.println();
		System.out.println("-------------------开始洗牌--------------------");
		play.shuffleCards();
		System.out.println("-------------------洗牌结束！--------------------");
		System.out.print("为：[");
		count = 0;
		for (Card card : play.newCardsList) {
			System.out.print(card.id + ":" + card.name);
			if (count < play.newCardsList.size() - 1) {
				System.out.print(", ");
			}
			count++;
		}
		System.out.print("]");

		System.out.println();
		System.out.println();
		System.out.println("-------------------创建玩家--------------------");
		play.createPlayer();
		for (Player player : play.playerList) {
			System.out.println("----欢迎玩家：" + player.name);
		}

		System.out.println();
		System.out.println("-------------------开始发牌--------------------");
		play.dealCards();
		System.out.println("-------------------发牌结束！--------------------");

		System.out.println();
		System.out.println("-------------------开始游戏--------------------");
		Map<Player, Card> playerCardMap = new HashMap<Player, Card>();
		for (Player player : play.playerList) {
			System.out.print("玩家：" + player.name + "最大的手牌为：");
			System.out.print(play.getMaxCard(player).name);
			playerCardMap.put(player, play.getMaxCard(player));
			System.out.println();
		}

		System.out.println();
		String winner = play.compareCard(playerCardMap).name;
		System.out.println("-------------------玩家：" + winner + "获胜！--------------------");

		System.out.println("玩家各自手牌为：");
		for (Player player : play.playerList) {
			System.out.print(player.name + "：");
			System.out.print("[");
			int num = 0;
			for (Card card : player.cardList) {
				System.out.print(card.name);
				if (num < player.cardList.size() - 1) {
					System.out.print(", ");
				}
				num++;
			}
			System.out.print("]");
			System.out.println();
		}
	}

	/**
	 * 
	 * @Title: createCards @Description: 创建扑克牌 @param 设定文件 @return void
	 *         返回类型 @throws
	 */
	private void createCards() {
		String[] arrSuit = { "黑桃", "红桃", "梅花", "方片" };
		String[] arrPoint = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };

		// 设置faceMap，用于后续比较花色
		faceMap = new HashMap<Integer, String>();
		for (int i = 0; i < arrSuit.length; i++) {
			faceMap.put(i, arrSuit[i]);
		}
		// 设置pointMap，用于后续比较点数
		pointMap = new HashMap<Integer, String>();
		for (int i = 0; i < arrPoint.length; i++) {
			pointMap.put(i, arrPoint[i]);
		}

		int count = 0;
		cardsList = new ArrayList<Card>();
		for (int i = 0; i < arrSuit.length; i++) {
			for (int j = 0; j < arrPoint.length; j++) {
				Card card = new Card();
				card.id = count;
				card.name = arrSuit[i] + arrPoint[j];
				cardsList.add(card);
				count++;
			}
		}
	}

	/**
	 * 
	 * @Title: shuffleCards @Description: 洗牌 @param 设定文件 @return void
	 *         返回类型 @throws
	 */
	private void shuffleCards() {
		newCardsList = new ArrayList<Card>();
		int count = 0;
		int tmp = 0;
		int cardsListSize = cardsList.size();

		while (count < 52) {
			tmp = Integer.valueOf(new Random().nextInt(52));
			if (tmp >= 0 && tmp < cardsListSize) {
				Card card = new Card();
				card.id = tmp;
				card.name = cardsList.get(tmp).name;
				if (newCardsList.contains(card)) {
					continue;
				}
				newCardsList.add(card);
				count++;
			}
		}

	}

	/**
	 * 
	 * @Title: dealCards @Description: 创建玩家 @param 设定文件 @return void
	 *         返回类型 @throws
	 */
	private void createPlayer() {
		boolean flag = false;
		Scanner scanner = null;
		Player player = null;
		playerList = new ArrayList<Player>();

		for (int i = 0; i < 2; i++) {
			player = new Player();
			System.out.println("请输入第" + (i + 1) + "位玩家的ID和姓名：");
			flag = false;
			while (!flag) {
				try {
					System.out.println("输入ID：");
					scanner = new Scanner(System.in);
					player.id = scanner.nextInt();
					flag = true;
				} catch (InputMismatchException e) {
					System.out.println("输入命令错误！请根据提示输入数字命令！");
				}
			}

			flag = false;
			while (!flag) {
				try {
					System.out.println("输入姓名：");
					scanner = new Scanner(System.in);
					player.name = scanner.nextLine();
					flag = true;
				} catch (InputMismatchException e) {
					System.out.println("输入命令错误！请根据提示输入字符串命令！");
				}
			}
			playerList.add(player);
		}
		scanner.close();
	}

	/**
	 * 
	 * @Title: dealCards @Description: 发牌 @param 设定文件 @return void 返回类型 @throws
	 */
	private void dealCards() {
		int count = 0;
		for (int i = 0; i < 2; i++) {
			for (Player player : playerList) {
				System.out.println("----玩家：" + player.name + "-拿牌");
				player.cardList.add(newCardsList.get(count));
				count++;
			}
		}
	}

	/**
	 * 
	 * @Title: getMaxCard @Description: 获取玩家手上最大的牌 @param 设定文件 @return Card
	 *         返回类型 @throws
	 */
	private Card getMaxCard(Player player) {
		Card maxCard = null;
		String face = null;
		String point = null;
		List<String> iFaceList = new ArrayList<String>();
		List<String> iPointList = new ArrayList<String>();
		Map<Card, String> iFaceMap = new HashMap<Card, String>();
		Map<Card, String> iPointMap = new HashMap<Card, String>();

		for (Card card : player.cardList) {
			face = card.name.substring(0, 2);
			iFaceList.add(getKeyByValue(faceMap, face));
			iFaceMap.put(card, getKeyByValue(faceMap, face));

			point = card.name.substring(2);
			iPointList.add(getKeyByValue(pointMap, point));
			iPointMap.put(card, getKeyByValue(pointMap, point));
		}
		Collections.sort(iFaceList);
		Collections.sort(iPointList);
		if (iPointList.get(0) == iPointList.get(iPointList.size() - 1)) {
			maxCard = getCardKeyByValue(iFaceMap, iFaceList.get(iFaceList.size() - 1));
		} else {
			maxCard = getCardKeyByValue(iPointMap, iPointList.get(iPointList.size() - 1));
		}

		return maxCard;
	}

	/**
	 * 
	 * @Title: compareCard @Description: 比较玩家的扑克牌大小 @param 设定文件 @return Player
	 *         返回类型 @throws
	 */
	private Player compareCard(Map<Player, Card> playerCardMap) {
		Player winner = null;
		String face = null;
		String point = null;
		List<String> iFaceList = new ArrayList<String>();
		List<String> iPointList = new ArrayList<String>();
		Map<Player, String> iFaceMap = new HashMap<Player, String>();
		Map<Player, String> iPointMap = new HashMap<Player, String>();

		for (Map.Entry<Player, Card> entry : playerCardMap.entrySet()) {
			face = entry.getValue().name.substring(0, 2);
			iFaceList.add(getKeyByValue(faceMap, face));
			iFaceMap.put(entry.getKey(), getKeyByValue(faceMap, face));

			point = entry.getValue().name.substring(2);
			iPointList.add(getKeyByValue(pointMap, point));
			iPointMap.put(entry.getKey(), getKeyByValue(pointMap, point));
		}
		Collections.sort(iFaceList);
		Collections.sort(iPointList);
		if (iPointList.get(0) == iPointList.get(iPointList.size() - 1)) {
			winner = getPlayerKeyByValue(iFaceMap, iFaceList.get(iFaceList.size() - 1));
		} else {
			winner = getPlayerKeyByValue(iPointMap, iPointList.get(iPointList.size() - 1));
		}

		return winner;
	}

	/**
	 * 根据map的value获取map的key
	 * 
	 * @param map
	 * @param value
	 * @return
	 */
	private String getKeyByValue(Map<Integer, String> map, String value) {
		String key = "";
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			if (value != null && value.equals(entry.getValue())) {
				key = entry.getKey().toString();
			}
		}
		return key;
	}

	/**
	 * 根据map的value获取map的key(Card对象)
	 * 
	 * @param map
	 * @param value
	 * @return
	 */
	private Card getCardKeyByValue(Map<Card, String> map, String value) {
		Card key = null;
		for (Map.Entry<Card, String> entry : map.entrySet()) {
			if (value != null && value.equals(entry.getValue())) {
				key = entry.getKey();
			}
		}
		return key;
	}

	/**
	 * 根据map的value获取map的key(Card对象)
	 * 
	 * @param map
	 * @param value
	 * @return
	 */
	private Player getPlayerKeyByValue(Map<Player, String> map, String value) {
		Player key = null;
		for (Map.Entry<Player, String> entry : map.entrySet()) {
			if (value != null && value.equals(entry.getValue())) {
				key = entry.getKey();
			}
		}
		return key;
	}

}
