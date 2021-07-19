class EntityMapper:
    @classmethod
    def map_status(cls, response_body):
        if response_body is None:
            return None
        members = {
            "id": response_body.get("id"),
            "uri": response_body.get("url"),
            "created_at": response_body.get("created_at"),
            "account": EntityMapper.map_account(response_body.get("account")),
            "content": response_body.get("content"),
            "visibility": response_body.get("visibility"),
            "sensitive": response_body.get("sensitive"),
            "spoiler_text": response_body.get("spoiler_text"),
            "media_attachments": [EntityMapper.map_attachment(a) for a in response_body.get("media_attachments", [])],
            "application": response_body.get("application"),
            "mentions": [EntityMapper.map_mention(m) for m in response_body.get("mentions", [])],
            "tags": [EntityMapper.map_tag(t) for t in response_body.get("tags", [])],
            "emojis": [EntityMapper.map_emoji(e) for e in response_body.get("emojis", [])],
            "reblogs_count": response_body.get("reblogs_count"),
            "favourites_count": response_body.get("favourites_count"),
            "replies_count": response_body.get("replies_count"),
            "url": response_body.get("url"),
            "in_reply_to_id": response_body.get("in_reply_to_id"),
            "in_reply_to_account_id": response_body.get("in_reply_to_account_id"),
            "relog": response_body.get("relog"),
            "poll": EntityMapper.map_poll(response_body.get("poll")),
            "card": EntityMapper.map_card(response_body.get("card")),
            "language": response_body.get("language"),
            "text": response_body.get("text"),
            "favourited": response_body.get("favourited"),
            "reblogged": response_body.get("reblogged"),
            "muted": response_body.get("muted"),
            "bookmarked": response_body.get("bookmarked"),
            "pinned": response_body.get("pinned")
        }
        return type("Status", (object,), members)

    @classmethod
    def map_card(cls, response_body):
        if response_body is None:
            return None
        members = {
            "url": response_body.get("url"),
            "title": response_body.get("title"),
            "description": response_body.get("description"),
            "type": response_body.get("type"),
            "author_name": response_body.get("author_name"),
            "author_url": response_body.get("author_url"),
            "provider_name": response_body.get("provider_name"),
            "provider_url": response_body.get("provider_url"),
            "html": response_body.get("html"),
            "width": response_body.get("width"),
            "height": response_body.get("height"),
            "image": response_body.get("image"),
            "embed_url": response_body.get("embed_url"),
            "blurhash": response_body.get("blurhash")
        }
        return type("Card", (object,), members)

    @classmethod
    def map_poll(cls, response_body):
        if response_body is None:
            return None
        members = {
            "id": response_body.get("id"),
            "expires_at": response_body.get("expires_at"),
            "expired": response_body.get("expired"),
            "multiple": response_body.get("multiple"),
            "votes_count": response_body.get("votes_count"),
            "voters_count": response_body.get("voters_count"),
            "voted": response_body.get("voted"),
            "own_votes": [ov for ov in response_body.get("own_votes")],
            "options": EntityMapper.map_poll_option(response_body.get("options")),
            "emojis": [EntityMapper.map_emoji(e) for e in response_body.get("emojis", [])]
        }
        return type("Poll", (object,), members)

    @classmethod
    def map_poll_option(cls, response_body):
        if response_body is None:
            return None
        members = {
            "title": response_body.get("title"),
            "votes_count": response_body.get("votes_count")
        }
        return type("PollOption", (object,), members)

    @classmethod
    def map_account(cls, response_body):
        if response_body is None:
            return None
        members = {
            "id": response_body.get("id"),
            "username": response_body.get("username"),
            "acct": response_body.get("acct"),
            "display_name": response_body.get("display_name"),
            "locked": response_body.get("locked"),
            "bot": response_body.get("bot"),
            "created_at": response_body.get("created_at"),
            "note": response_body.get("note"),
            "url": response_body.get("url"),
            "avatar": response_body.get("avatar"),
            "avatar_static": response_body.get("avatar_static"),
            "header": response_body.get("header"),
            "header_static": response_body.get("header_static"),
            "followers_count": response_body.get("followers_count"),
            "following_count": response_body.get("following_count"),
            "statuses_count": response_body.get("statuses_count"),
            "last_status_at": response_body.get("last_status_at"),
            "discoverable": response_body.get("discoverable"),
            "emojis": [EntityMapper.map_emoji(e) for e in response_body.get("emojis", [])],
            "fields": [EntityMapper.map_field(f) for f in response_body.get("fields")],
            "moved": response_body.get("moved"),
            "suspend": response_body.get("suspend"),
            "mute_expires_at": response_body.get("mute_expires_at"),
            "source": response_body.get("source")
        }
        return type("Account", (object,), members)

    @classmethod
    def map_attachment(cls, response_body):
        if response_body is None:
            return None
        members = {
            "id": response_body.get("id"),
            "type": response_body.get("type"),
            "url": response_body.get("url"),
            "preview_url": response_body.get("preview_url"),
            "remote_url": response_body.get("remote_url"),
            "text_url": response_body.get("text_url"),
            "meta": EntityMapper.map_meta(response_body.get("meta")),
            "description": response_body.get("description"),
            "blurhash": response_body.get("blurhash")
        }
        return type("Attachment", (object,), members)

    @classmethod
    def map_mention(cls, response_body):
        if response_body is None:
            return None
        members = {
            "id": response_body.get("id"),
            "username": response_body.get("username"),
            "url": response_body.get("url"),
            "acct": response_body.get("acct")
        }
        return type("Mention", (object,), members)

    @classmethod
    def map_notification(cls, response_body):
        if response_body is None:
            return None
        members = {
            "id": response_body.get("id"),
            "type": response_body.get("type"),
            "created_at": response_body.get("created_at"),
            "account": EntityMapper.map_account(response_body.get("account")),
            "status": EntityMapper.map_status(response_body.get("status"))
        }
        return type("Notification", (object,), members)

    @classmethod
    def map_tag(cls, response_body):
        if response_body is None:
            return None
        members = {
            "name": response_body.get("name"),
            "url": response_body.get("url"),
            "history": [EntityMapper.map_history(h) for h in response_body.get("history", [])]
        }
        return type("Tag", (object,), members)

    @classmethod
    def map_emoji(cls, response_body):
        if response_body is None:
            return None
        members = {
            "shortcode": response_body.get("shortcode"),
            "url": response_body.get("url"),
            "static_url": response_body.get("static_url"),
            "visible_in_picker": response_body.get("visible_in_picker"),
            "category": response_body.get("category")
        }
        return type("Emoji", (object,), members)

    @classmethod
    def map_field(cls, response_body):
        if response_body is None:
            return None
        members = {
            "name": response_body.get("name"),
            "value": response_body.get("value"),
            "verified_at": response_body.get("verified_at")
        }
        return type("Field", (object,), members)

    @classmethod
    def map_history(cls, response_body):
        if response_body is None:
            return None
        members = {
            "day": response_body.get("day"),
            "uses": response_body.get("uses"),
            "accounts": response_body.get("accounts")
        }
        return type("History", (object,), members)

    @classmethod
    def map_meta(cls, response_body):
        if response_body is None:
            return None
        members = {
            "meta": None
        }
        return type("Meta", (object,), members)
