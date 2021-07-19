from api_entities import EntityMapper


class TimelineHandler:
    @classmethod
    def handle(cls, statuses):
        if statuses is not None and len(statuses) > 0:
            return [EntityMapper.map_status(s) for s in statuses]
        return None
