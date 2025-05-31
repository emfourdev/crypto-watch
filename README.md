# Crypto Watch

Crypto Watch is a lightweight Java console application that retrieves real-time cryptocurrency prices from the [CoinGecko API](https://www.coingecko.com/en/api) — no external libraries or dependencies required.

## 📦 Features

- Fetches live price data for one or more cryptocurrencies in USD.
- Command-line interface (CLI).
- No external libraries — uses only Java standard library (`java.net`, `java.io`).
- Works out of the box with JDK 17+.

## 🚀 Getting Started

### 🛠 Requirements

- Java Development Kit (JDK) 17 or later

### 🔧 Compilation

Download `CryptoWatch.java`, then compile it using:

```bash
javac CryptoWatch.java
```

### ▶️ Usage

```bash
java CryptoWatch [coin_id...]
```

Example:

```bash
java CryptoWatch bitcoin ethereum dogecoin
```

Output:

```
bitcoin → $69000 USD
ethereum → $3700 USD
dogecoin → $0.18 USD
```

> 💡 Use lowercase CoinGecko IDs. You can find them in the [CoinGecko coin list](https://api.coingecko.com/api/v3/coins/list).

## 📄 License

This project is licensed under the **GNU General Public License v3.0 (GPL-3.0)** — see the [LICENSE](https://www.gnu.org/licenses/gpl-3.0.html) for details.


---

*Crypto Watch is a simple educational tool — always double-check prices with a trusted financial source before making decisions.*
