# Falaky (فلكي)

Android TV IPTV client (Xtream) with a Netflix-style browse UI. Kotlin, Compose for TV, Room, Hilt, Media3 (stage 2).
TV only. Release builds only. No local build is needed: GitHub Actions builds everything.

- Setup (no local tools): [docs/SETUP.md](docs/SETUP.md)
- Architecture and decisions: [docs/ARCHITECTURE.md](docs/ARCHITECTURE.md)
- Work list: [BACKLOG.md](BACKLOG.md)

Secrets never go in git: signing keystore, Firebase config, TMDB and Gemini keys (users enter their own on the device).
